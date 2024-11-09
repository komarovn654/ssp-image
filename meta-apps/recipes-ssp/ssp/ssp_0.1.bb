SUMMARY = "Slideshow player recipe"
DESCRIPTION = "Slideshow player recipe"
HOMEPAGE = "https://github.com/yourusername/myapp"
LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=<3da9cfbcb788c80a0384361b4de20420>"

SRC_URI = "gitsm://github.com/komarovn654/slideshow_player.git;branch=es2;protocol=https"
# SRC_URI = "git://github.com/komarovn654/slideshow_player.git;branch=es2;protocol=https"
SRCREV = "${AUTOREV}"
# SRCREV = "39bef6a2ef745c82feeb2095cc60f12b2108b360"

S = "${WORKDIR}/git"

# gitsm doesn't work with the devtool
# do_configure:prepend() {
#   cd ${S}
#   git submodule update --init --recursive
# }

# Add Wayland libraries to the dependencies
DEPENDS = "wayland wayland-protocols wayland-native pkgconfig-native libxkbcommon mesa-pvr"

inherit cmake

EXTRA_OECMAKE = "-DSSP_BUILD_TESTS=OFF -DSSP_BUILD_EXAMPLES=OFF -DSSP_PLATFORM=SSP_DP_WAYLAND"

# Custom installation
do_install() {
    # CMake usually handles installation automatically if specified in CMakeLists.txt,
    # but you can add any additional install steps if needed.
    mkdir -p ${D}${sysconfdir}
    cp ${S}/ssp_config.ini ${D}${sysconfdir}/ssp_config.ini

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/build/src/ssp ${D}${bindir}/
}

# Runtime dependencies (optional, based on your application)
# RDEPENDS:${PN} += "libexample"

# Additional packaging paths if needed
# FILES:${PN} += "${bindir}/myapp"
