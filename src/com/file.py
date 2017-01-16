#coding:utf-8

f=open("id.txt")
lines = f.readlines();
for l in lines:
    print l.strip('\n')+','
f.close()