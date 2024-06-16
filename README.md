# XMake Demo of verilator + verilog/chisel

一个使用XMake构建verilator和verilog/chisel的工程样例

`verilog`文件夹下包含使用`verilog`的例子，`chisel`文件下包含使用`chisel`+`mill`的例子。

可配置仿真最大波形记录周期数，运行完之后自动运行`gtkwave`查看记录波形。

```bash
# build & run verilog demo
$ make verilog
# build & run chisel demo
$ make chisel
# menuconfig
$ make config
```
