require recipes-images/images/core-image.inc
inherit core-image

IMAGE_FEATURES:append = "\
    weston \
	"

WESTON_BASE = "\
    packagegroup-core-weston \
    xwayland \
    "

LVGL = "lvgl-demo-fb"

IMAGE_INSTALL:append:genericx86-64 = " mesa-demos"

IMAGE_INSTALL:append:raspberrypi3-64 = " \
    raspi-gpio \
    rpio \
    udev-rules-rpi \
    "

IMAGE_INSTALL:append = "\
    ${LVGL} \
    ${WESTON_BASE} \
    "