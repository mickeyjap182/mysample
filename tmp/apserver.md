# using app server resin.
https://www.caucho.com/resin-4.0/admin/starting-resin.xtp#OtherUnixLinuxSolarisandMacOSX

./configure --prefix=/usr/local/share/resin \
            --with-resin-root=/var/resin \
            --with-resin-log=/var/log/resin \
            --with-resin-conf=/etc/resin \
            --with-openssl=/usr/local/opt/openssl

- 'openssl error'.
https://github.com/vysheng/tg/issues/1488

- make
it is make errors.
```
gcc -g -O2 -D_POSIX_PTHREAD_SEMANTICS -DB64 -arch x86_64 -DHAS_SOCK_TIMEOUT -DHAS_JVMTI  -DRESIN_HOME=\"/usr/local/share/resin\" -I/usr/local/opt/openssl/include -I/Library/Java/JavaVirtualMachines/openjdk-12.0.1.jdk/Contents/Home/include -I/Library/Java/JavaVirtualMachines/openjdk-12.0.1.jdk/Contents/Home/include/darwin -I../common -DCPU=\"x86_64\" -DOS=   -c -o jni_socket.o jni_socket.c
jni_socket.c:918:1: warning: control may reach end of non-void function [-Wreturn-type]
}
^
jni_socket.c:1331:51: warning: passing 'int *' to parameter of type 'socklen_t *' (aka 'unsigned int *')
      converts between pointers to integer types with different sign [-Wpointer-sign]
  getsockname(sock, (struct sockaddr *) sin_data, &sin_length);
                                                  ^~~~~~~~~~~
/Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/include/sys/socket.h:697:78: note: passing argument to
      parameter here
int     getsockname(int, struct sockaddr * __restrict, socklen_t * __restrict)
                                                                             ^
2 warnings generated.
```
```
gcc -g -O2 -D_POSIX_PTHREAD_SEMANTICS -DB64 -arch x86_64 -DHAS_SOCK_TIMEOUT -DHAS_JVMTI  -DRESIN_HOME=\"/usr/local/share/resin\" -I/usr/local/opt/openssl/include -I/Library/Java/JavaVirtualMachines/openjdk-12.0.1.jdk/Contents/Home/include -I/Library/Java/JavaVirtualMachines/openjdk-12.0.1.jdk/Contents/Home/include/darwin -I../common -DCPU=\"x86_64\" -DOS=   -c -o std.o std.c
std.c:575:39: warning: passing 'int *' to parameter of type 'socklen_t *' (aka 'unsigned int *') converts
      between pointers to integer types with different sign [-Wpointer-sign]
  getsockname(sock, conn->server_sin, &sin_len);
                                      ^~~~~~~~
/Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/include/sys/socket.h:697:78: note: passing argument to
      parameter here
int     getsockname(int, struct sockaddr * __restrict, socklen_t * __restrict)

```

sudo resinctl start
or
java -jar lib/resin.jar start


.libs/app/resin-data/ is carefully