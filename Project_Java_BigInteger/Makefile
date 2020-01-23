JAVAC =javac
JAVAC_FLAGS =-encoding SJIS

all:	SystemInformation.class PrimeFactorization.class Main.class

SystemInformation.class:	PrimeFactorization/SystemInformation/SystemInformation.java
	$(JAVAC) $(JAVAC_FLAGS) $<

PrimeFactorization.class:	PrimeFactorization/PrimeFactorization.java
	$(JAVAC) $(JAVAC_FLAGS) $<

Main.class:	Main.java
	$(JAVAC) $(JAVAC_FLAGS) $<

clean:
	rm ./*.class

.PHONY:	all clean
