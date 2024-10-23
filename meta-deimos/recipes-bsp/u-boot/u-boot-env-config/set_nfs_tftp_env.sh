# /usr/local/bin/set_nfs_tftp_env.sh
fw_setenv ipaddr 192.168.1.100
fw_setenv serverip 192.168.1.1
fw_setenv rootpath /nfsroot
fw_setenv bootfile zImage
fw_setenv nfsboot 'setenv bootargs console=ttyO0,115200n8 root=/dev/nfs rw nfsroot=${serverip}:${rootpath},vers=3 ip=${ipaddr}:${serverip}::255.255.255.0::eth0:off; tftp ${loadaddr} ${bootfile}; bootm'
