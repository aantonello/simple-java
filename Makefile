# ============================================================================
# Makefile
# ============================================================================

# ----------------------------------------------------------------------------
# Universal include file
# ----------------------------------------------------------------------------
include make.inc

# ----------------------------------------------------------------------------
# EXECUTABLES FOR WINDOWS AND MAC
# ----------------------------------------------------------------------------
ifeq "$(HOMEDRIVE)" "C:"
JC = $(JAVA_HOME)/bin/javac.exe
JL = $(JAVA_HOME)/bin/jar.exe
RC = $(JAVA_HOME)/bin/jar.exe
CP = rsync
DS := \;
else
JC = javac
JL = jar
RC = jar
CP = rsync
DS := :
endif

# ----------------------------------------------------------------------------
# BOOTCLASSPATH
# ----------------------------------------------------------------------------
JREDIR = $(JAVA_HOME)/jre/lib
BOOTCP = -bootclasspath $(JREDIR)/rt.jar

# ----------------------------------------------------------------------------
# COMMAND LINE OPTIONS
# ----------------------------------------------------------------------------
OPTIONS = -source 1.6 -target 1.6 -encoding UTF-8 -Xlint:deprecation -Xmaxerrs 10

# ----------------------------------------------------------------------------
# COMPILER (AND LINKER?) FLAGS
# ----------------------------------------------------------------------------
COMPILE = $(OPTIONS) -d $(TMPDIR) -cp $(TMPDIR)
MAKEJAR = cMf $(OUTPUT) -C $(TMPDIR) .
MAKERES = uf $(OUTPUT) -C $(RESDIR) .

# ----------------------------------------------------------------------------
# COPY OPTIONS (RSYNC)
# ----------------------------------------------------------------------------
COPY = -vcruptOmC --no-o --no-g --delete --delete-excluded --exclude='.*.sw?'

# ----------------------------------------------------------------------------
# TARGETS
# ----------------------------------------------------------------------------
.PHONY: all clean cleanall install docs

default: all

all: clean $(OUTPUT)

clean:
	rm -fr ./$(BINDIR)
	rm -fr ./$(TMPDIR)

cleanall : clean
	rm -fr ./$(DOCDIR)

$(JARDIR) $(DOCDIR) $(BINDIR) $(TMPDIR) :
	mkdir -p $@

$(OUTPUT) : $(TMPDIR) $(BINDIR)
	$(JC) $(COMPILE) $(_FILES_)
	$(JL) $(MAKEJAR)
#	$(RC) $(MAKERES)

docs: $(DOCDIR)
	( cat doxyfile ; echo "$(PROJECTNUMBER)" ; echo "$(TAGFILE)" ) | doxygen -
	rm ./debug.txt

install : $(JARDIR)
	$(CP) $(COPY) $(OUTPUT) $(JARDIR)
	$(CP) $(COPY) $(OUTDXT) $(PUBDIR)
	$(CP) $(COPY) $(RESDIR) $(PUBDIR)
	publish -doc plx/$(TARGET) -f -q


