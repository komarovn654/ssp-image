SUMMARY = "Picman recipe"
DESCRIPTION = "Picman recipe"
LICENSE = "CLOSED"

SRC_URI = "file://src/"

S = "${WORKDIR}/src"

DEPENDS = "go-native"

export GO111MODULE="on"

inherit go

do_fetch[network] = "1"

do_compile[network] = "1"

do_compile() {
    cd ${S}
    go mod tidy
    cd ${S}/cmd
    go build -o picman .
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/cmd/picman ${D}${bindir}/picman
}
