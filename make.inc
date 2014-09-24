# ============================================================================
# make.inc
# Included in Makefile
# vim:ft=make
# ============================================================================

# ----------------------------------------------------------------------------
# BASIC DIRECTORIES
# ----------------------------------------------------------------------------
SRCDIR = src/sf
BINDIR = bin/jar
TMPDIR = bin/tmp
DOCDIR = docs/help
RESDIR = res
TARGET = simple
APPVER = 2.5
BUILD  = 1

# ----------------------------------------------------------------------------
# OUTPUT DIRECTORIES
# ----------------------------------------------------------------------------
PUBDIR = $(WORKHOME)/libs/$(TARGET)-$(APPVER)
JARDIR = $(PUBDIR)/jar

# ----------------------------------------------------------------------------
# OUTPUT FILES
# ----------------------------------------------------------------------------
OUTPUT = $(BINDIR)/$(TARGET).jar
OUTDXT = $(DOCDIR)/$(TARGET).dxt

# ----------------------------------------------------------------------------
# DOXYGEN SETTINGS
# ----------------------------------------------------------------------------
PROJECTNUMBER=PROJECT_NUMBER=$(APPVER).$(BUILD)
TAGFILE=GENERATE_TAGFILE=$(OUTDXT)

# ----------------------------------------------------------------------------
# FILES TO COMPILE
# ----------------------------------------------------------------------------
_LANG_=$(SRCDIR)/lang/ERROR.java\
	$(SRCDIR)/lang/ENC.java\
	$(SRCDIR)/lang/arrays.java\
	$(SRCDIR)/lang/numbers.java\
	$(SRCDIR)/lang/strings.java

_UTILS_=$(SRCDIR)/utils/SFDateTime.java

_FILES_=$(_LANG_) $(_UTILS_)

