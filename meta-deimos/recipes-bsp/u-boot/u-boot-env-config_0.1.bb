SUMMARY = "U-Boot variables"
DESCRIPTION = "Script for dynamic setting of variables in U-Boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=65ba821626cd2a2100e35e66326f31df"

SRC_URI = "file://fw_env.config \
           file://set_nfs_tftp_env.sh \
           file://COPYING"

# SRC_URI[md5sum] = "e74b224ac4227562ae43934a0f409a03"

FILES:${PN} = "${bindir}/set_nfs_tftp_env.sh"
FILES:${PN} += "${sysconfdir}/*"

do_install() {
    mkdir -p ${D}${sysconfdir}
    cp ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/set_nfs_tftp_env.sh ${D}${bindir}/set_nfs_tftp_env.sh
}

# Add the script to run at boot (optional)
# ROOTFS_POSTPROCESS_COMMAND += "cp ${WORKDIR}/set_ipaddr.sh ${D}/etc/init.d/; \
#                                update-rc.d set_ipaddr.sh defaults;"

RDEPENDS_${PN} = "u-boot-tools"