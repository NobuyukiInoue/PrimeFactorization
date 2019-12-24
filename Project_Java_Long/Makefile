JAVAC =javac
# JAVAC_FLAGS =-encoding SJIS

all:	Out.class ExLong.class SystemInformation.class PrimeFactorization.class Main.class

Out.class:	ExLong/Out/Out.java
	$(JAVAC) $(JAVAC_FLAGS) $<

ExLong.class:	ExLong/ExLong.java
	$(JAVAC) $(JAVAC_FLAGS) $<

SystemInformation.class:	PrimeFactorization/SystemInformation/SystemInformation.java
	$(JAVAC) $(JAVAC_FLAGS) $<

PrimeFactorization.class:	PrimeFactorization/PrimeFactorization.java
	$(JAVAC) $(JAVAC_FLAGS) $<

Main.class:	Main.java
	$(JAVAC) $(JAVAC_FLAGS) $<

clean:
	rm ./*.class

.PHONY:	all clean
