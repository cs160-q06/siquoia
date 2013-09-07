0.-Tools-Presentation
=====================

Assignment 1: Tools Presentation


The LaTeX file uses the beamer documentclass, which is for creating 
presentations.  The PDF file is generated from the LaTeX source file 
using pdflatex.


Installing the tools needed to process the LaTeX file
-----------------------------------------------------

On a Debian-based GNU/Linux system (i.e., Trisquel GNU/Linux):

    sudo apt-get install texlive latex-beamer


On an Arch-based GNU/Linux system (i.e., Parabola GNU/Linux):

    sudo pacman -S texlive-core

On an RPM-based GNU/Linux system (i.e., BLAG Linux and GNU):

    sudo yum install texlive texlive-latex texlive-beamer 


Generating the PDF file from the LaTeX file
-------------------------------------------

    pdflatex 0-tools.tex
