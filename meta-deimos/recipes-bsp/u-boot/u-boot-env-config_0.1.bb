SUMMARY = "U-Boot variables"
DESCRIPTION = "Script for dynamic setting of variables in U-Boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=65ba821626cd2a2100e35e66326f31df"

SRC_URI = "file://fw_env.config \
           file://set_nfs_tftp_env.sh \
           file://COPYING"

FILES:${PN} = "${bindir}/set_nfs_tftp_env.sh"
FILES:${PN} += "${sysconfdir}/*"

do_install() {
    mkdir -p ${D}${sysconfdir}
    cp ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/set_nfs_tftp_env.sh ${D}${bindir}/set_nfs_tftp_env.sh
}

RDEPENDS_${PN} = "u-boot-tools"
