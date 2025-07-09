inherit core-image

IMAGE_DEV_MANAGER = "udev"

IMAGE_LINGUAS = "pt-br"

IMAGE_FEATURES:append = "\
	splash \
	package-management \
    ssh-server-openssh \
	debug-tweaks \
	allow-empty-password \
    allow-root-login \
	"

IMAGE_FEATURES:remove = " perf"

IMAGE_OVERHEAD_FACTOR = "2"

FONTS = "\
	ttf-dejavu \
	liberation-font \
	"
PYTHON = "\
    python3 \
    python3-gpiod \
    python3-dev \
    python3-spidev \
    python3-virtualenv \
    python3-pillow \
    python3-pip \
  	python3-pybind11 \
    python3-misc \
    python3-modules \
    python3-io \
    python3-json \
    python3-logging \
    python3-threading \
    python3-multiprocessing \
    "


CORE = "\
    vim \
    git \
    logrotate \
    htop \
    net-tools \
    rsync \
    nano \
    wget \
    curl \
    spidev-test \
    minicom \
    i2c-tools \
    libgpiod \
    libgpiod-tools \
    libgpiod-dev \
    ${PYTHON} \
    "

IMAGE_INSTALL:append:raspberrypi3-64 = " \
    raspi-gpio \
    rpio \
    udev-rules-rpi \
    "

IMAGE_INSTALL:append = "\
    packagegroup-core-boot \
    kernel-modules \
    ${CORE} \
    "