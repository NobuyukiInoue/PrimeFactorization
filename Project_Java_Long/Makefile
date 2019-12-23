JAVAC =javac
JAVAC_FLAGS =-encoding SJIS

all:	PrimeFactorization.class Main.class

PrimeFactorization.class:	PrimeFactorization.java
	$(JAVAC) $(JAVAC_FLAGS) $<

Main.class:	Main.java
	$(JAVAC) $(JAVAC_FLAGS) $<

clean:
	rm ./*.class

.PHONY:	all clean
