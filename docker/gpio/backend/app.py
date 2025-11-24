# backend/app.py
from flask import Flask, jsonify
from flask_cors import CORS
import os

app = Flask(__name__)
CORS(app) 

LED_PATH = '/sys/class/leds/ACT' 
TRIGGER_PATH = os.path.join(LED_PATH, 'trigger')
BRIGHTNESS_PATH = os.path.join(LED_PATH, 'brightness')

def initialize_led():
    if not os.path.exists(LED_PATH):
        print(f"ERRO: Caminho do LED {LED_PATH} não encontrado. Verifique se o nome do LED está correto.")
        return False
        
    try:
        with open(TRIGGER_PATH, 'w') as f:
            f.write('none')
        print("Trigger do LED ACT configurado para 'none'.")
        
        set_led_brightness(0)
        return True
    except IOError as e:
        print(f"ERRO: Falha ao inicializar o LED. Permissões ou mapeamento de volume ausentes. {e}")
        return False

def set_led_brightness(value):
    """Escreve 0 (desliga) ou 1 (liga) no arquivo brightness."""
    try:
        with open(BRIGHTNESS_PATH, 'w') as f:
            f.write(str(value))
        return True
    except IOError as e:
        print(f"ERRO: Falha ao controlar brightness. Permissão de escrita necessária. {e}")
        return False

LED_CONTROL_ENABLED = initialize_led()

@app.route('/led/<string:action>', methods=['GET'])
def control_led(action):
    if not LED_CONTROL_ENABLED:
        return jsonify({"status": "error", "message": "Controle do LED desabilitado. Verifique logs de inicialização."}), 500

    if action == 'on':
        success = set_led_brightness(1)
        status_msg = "ligado"
    elif action == 'off':
        success = set_led_brightness(0)
        status_msg = "desligado"
    else:
        return jsonify({"status": "error", "message": "Ação inválida. Use 'on' ou 'off'."}), 400

    if success:
        print(f"LED ACT alterado para: {status_msg}")
        return jsonify({
            "status": "success", 
            "led": "ACT", 
            "action": action, 
            "message": f"LED ACT {status_msg}."
        })
    else:
        return jsonify({"status": "error", "message": "Falha na escrita do brilho. Verifique permissões."}), 500

@app.route('/status', methods=['GET'])
def get_status():
    return jsonify({"status": "running", "led_control": LED_CONTROL_ENABLED})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)