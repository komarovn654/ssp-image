SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_FEATURES += "ssh-server-dropbear nfs-client weston"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

IMAGE_INSTALL:append = " wayland wayland-protocols"
IMAGE_INSTALL:append = " mesa"
IMAGE_INSTALL:append = " libegl-mesa libgles2-mesa"
IMAGE_INSTALL:append = " python3"
IMAGE_INSTALL:append = " libinput"

IMAGE_INSTALL:append = " kernel-module-evdev"
IMAGE_INSTALL:append = " u-boot-tools u-boot-env-config libubootenv-bin"
# IMAGE_INSTALL:append = " kernel-module-g-ether"
# IMAGE_INSTALL:append = " kernel-module-cpsw"

VIRTUAL-RUNTIME_init_manager = "systemd"
