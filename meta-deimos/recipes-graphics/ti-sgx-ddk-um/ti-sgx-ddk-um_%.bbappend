FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-rc.pvr-add-proper-error-return-code.patch"

pkg_postinst:${PN}() {
echo "SUCHARA"
exit 0
}