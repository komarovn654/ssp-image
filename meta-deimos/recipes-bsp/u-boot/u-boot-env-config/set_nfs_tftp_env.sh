# /usr/local/bin/set_nfs_tftp_env.sh
fw_setenv ipaddr 192.168.0.100
fw_setenv serverip 192.168.0.15
fw_setenv rootpath /home/nikolay/dev/nfsroot/core-image-deimos-beaglebone
fw_setenv bootfile zImage
fw_setenv dtbfile am335x-boneblack-beaglebone.dtb
# fw_setenv nfsboot 'setenv bootargs console=ttyO0,115200n8 root=/dev/nfs rw nfsroot=${serverip}:${rootpath},vers=3 ip=${ipaddr}:${serverip}::255.255.255.0::eth0:off; tftp ${loadaddr} ${bootfile}; bootm'
fw_setenv tftpload 'tftp ${loadaddr} ${bootfile}; tftp ${fdtaddr} ${dtbfile}; bootz ${loadaddr} - ${fdtaddr}'
fw_setenv nfsboot 'setenv bootargs console=ttyO0,115200n8 root=/dev/nfs rw nfsroot=${serverip}:${rootpath},vers=3 ip=${ipaddr}; ${tftpload}'

