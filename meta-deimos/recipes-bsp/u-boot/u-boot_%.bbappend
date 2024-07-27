FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:deimos-uboot_features = "file://u-boot.cfg"