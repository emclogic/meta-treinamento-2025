inherit core-image

IMAGE_DEV_MANAGER = "udev"

IMAGE_LINGUAS = "pt-br"

IMAGE_FEATURES:append = "\
	splash \
	package-management \
    ssh-server-dropbear \
	debug-tweaks \
	allow-empty-password \
    allow-root-login \
	"

IMAGE_FEATURES:remove = "dev-pkgs perf"

IMAGE_OVERHEAD_FACTOR = "2"

FONTS = "\
	ttf-dejavu \
	liberation-font \
	"

CORE = "\
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

IMAGE_INSTALL:append = "\
    packagegroup-core-boot \
    packagegroup-basic \
    kernel-modules \
    ${CORE} \
    "