#!/bin/bash
PROJECTNAME=traffic-spider
pid=`ps -ef |grep $PROJECTNAME |grep -v "grep" |awk '{print $2}'`
DEPLOY_DIR=`pwd`
LOGS_DIR=""
#LOGS_DIR=$DEPLOY_DIR/logs
cd ../
mkdir logs
cd bin/
if [ ! -d $LOGS_DIR ]; then
        mkdir $LOGS_DIR
fi
if [ $pid ]; then
    echo "$PROJECTNAME  is  running  and pid=$pid"
else
   echo "Start success to start $PROJECTNAME ...."
   nohup java -jar ../lib/traffic-spider.jar  >> ../logs/$PROJECTNAME.log 2>&1 &
fi