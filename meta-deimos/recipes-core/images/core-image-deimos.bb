SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"

IMAGE_INSTALL:append = " nfs-utils nfs-utils-client"
IMAGE_INSTALL:append = " wayland wayland-protocols wayland-utils"
IMAGE_INSTALL:append = " mesa"
IMAGE_INSTALL:append = " libegl-mesa libgles2-mesa"
IMAGE_INSTALL:append = " weston weston-init weston-drm libinput"
VIRTUAL-RUNTIME_init_manager = "systemd"
IMAGE_INSTALL:append = " python3"
