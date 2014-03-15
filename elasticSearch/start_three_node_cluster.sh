#!/bin/sh

elasticsearch-1.0.1/bin/elasticsearch -d -Des.node.data=true -Des.node.master=true -Des.node.name=TestNodeOne
elasticsearch-1.0.1/bin/elasticsearch -d -Des.node.data=true -Des.node.master=false -Des.node.name=TestNodeTwo
elasticsearch-1.0.1/bin/elasticsearch -d -Des.node.data=true -Des.node.master=false -Des.node.name=TestNodeThree