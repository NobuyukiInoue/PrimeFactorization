# coding: utf-8

import datetime
import platform
from . import TimeFormatter

def printSystemInformation():
    print("=====================================================================================\n"
        "{0:10s} : {1}\n"
        "{2:10s} : {3}\n"
        "{4:10s} : {5}\n"
        "====================================================================================="
        .format(
            "Date", "{0:%Y-%m-%d %H:%M:%S}".format(datetime.datetime.now()),
            "OS", platform.system(),
            "Language", "Python3"
        ))
