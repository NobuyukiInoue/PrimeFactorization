CC=gcc
CC_FLAGS_DEBUG=-g -O0 -o
CC_FLAGS_RELEASE=-O3 -o
CC_FLAGS_MATH=-lm

PROJECT_NAME=primefactorization
SOURCE=$(PROJECT_NAME).c

MYLIB_PATH=./lib
MYLIB_NAME=*.c

ifeq ($(OS),Windows_NT)
	TARGET_FILE=$(PROJECT_NAME).exe
else
UNAME=${shell uname}
ifeq ($(UNAME),Darwin)
	TARGET_FILE=$(PROJECT_NAME)_for_mac
else
ifeq ($(UNAME),Linux)
	TARGET_FILE=$(PROJECT_NAME)_for_linux
else
	TARGET_FILE=$(PROJECT_NAME)
endif
endif
endif

all:	$(TARGET_FILE)

$(TARGET_FILE):	$(SOURCE) $(MYLIB_PATH)/$(MYLIB_NAME)
	$(CC) $(CC_FLAGS_RELEASE)$(TARGET_FILE) $(SOURCE) $(MYLIB_PATH)/$(MYLIB_NAME) $(CC_FLAGS_MATH)

debug:	$(SOURCE) $(MYLIB_PATH)/$(MYLIB_NAME)
	$(CC) $(CC_FLAGS_DEBUG)debug_$(TARGET_FILE) $(SOURCE) $(MYLIB_PATH)/$(MYLIB_NAME) $(CC_FLAGS_MATH)

clean:
	rm $(TARGET_FILE)	# Can not run on Windows

.PHONY:	all clean
