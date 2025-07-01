require recipes-images/images/core-image.inc
inherit core-image

LVGL = "lvgl-demo-fb \
        lvgl \
        libevdev \
        evtest \
        "
IMAGE_INSTALL:append = "\
    ${LVGL} \
    "


TOOLCHAIN_HOST_TASK:append = " nativesdk-cmake nativesdk-pkgconfig"
TOOLCHAIN_TARGET_TASK:append = " lvgl-dev"


TOOLCHAIN_TARGET_TASK:remove = " lvgl-demo-fb lvgl-demo-fb-dev "
