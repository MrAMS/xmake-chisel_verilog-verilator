verilog:
	xmake build verilog_demo
	xmake run verilog_demo

chisel:
	xmake build chisel
	xmake build chisel_demo
	xmake run chisel_demo

config:
	xmake f --menu

.PHONY: verilog chisel config