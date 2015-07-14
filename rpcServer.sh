#!/bin/sh 
#description: asteroid_server
path=/opt/develop/asteroidRpcServer
tpid=`ps aux | grep -c '$path/asteroidRpcServer.jar'` 

case "$1" in 

start) 
if [ $tpid -le 1 ]; then 
echo "asteroid_server service start..." 
java -Xms64m -Xmx128m -jar $path/asteroidRpcServer.jar >> /dev/null 2>&1 & 
echo $! > $path/server.pid 
else 
echo "asteroid_server service already started.PID: `cat $path/server.pid`" 
exit 0 
fi 
;; 

stop) 
echo "asteroid_server service stop..." 
kill -9 `cat $path/server.pid` 
rm -rf $path/server.pid 
;; 

restart) 
echo "asteroid_server service restart..." 
$0 stop 
sleep 1 
$0 start 
;; 

*) 
echo "Usage: asteroid_server.sh(start|stop|restart)" 
esac 

exit 0