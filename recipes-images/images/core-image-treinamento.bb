inherit core-image

IMAGE_DEV_MANAGER = "udev"
IMAGE_INIT_MANAGER = "systemd"
INIT_MANAGER = "systemd"

IMAGE_LINGUAS = "pt-br"

IMAGE_FEATURES:append = "\
	splash \
	package-management \
    ssh-server-dropbear \
    weston \
	debug-tweaks \
	allow-empty-password \
    allow-root-login \
	"

IMAGE_FEATURES:remove = "dev-pkgs perf"

IMAGE_FSTYPES:append = " wic.bz2 ext4"

IMAGE_OVERHEAD_FACTOR = "2"

FONTS = "\
	ttf-dejavu \
	liberation-font \
	"

CORE = "\
    systemd systemd-analyze systemd-bootchart \
    sysvinit-inittab \
    mesa \
    vim \
    logrotate \
    htop \
    net-tools \
    rsync \
    nano \
    wget \
    curl \
    python3 \
    "
WESTON_BASE = "\
    packagegroup-core-weston \
    xwayland \
    "

LVGL = "lvgl-demo-fb"

IMAGE_INSTALL:append:genericx86-64 = " mesa-demos"


IMAGE_INSTALL:append:raspberrypi3-64 = " \

    raspi-gpio \
        rpio
        udev-rules-rpi



    "



IMAGE_INSTALL:append = "\
    packagegroup-core-boot \
    packagegroup-basic \
    kernel-modules \
    ${CORE} \
    ${WESTON_BASE} \
    ${LVGL} \
    "
