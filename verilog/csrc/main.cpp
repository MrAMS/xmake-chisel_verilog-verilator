#include "verilog_demo.h"
#include "verilated.h"
#include "verilated_vcd_c.h"

#include "config_verilog.h"
#include <cstdint>

#include <fmt/core.h>
#include <fmt/color.h>

int main(int argc, char** argv) {
    fmt::print(bg(fmt::color::blue), "Hello Verilog\n");
    char const* vcdfile = "wave.vcd";
    VerilatedContext* contextp = new VerilatedContext;
    contextp->commandArgs(argc, argv);
    verilog_demo* top = new verilog_demo{contextp};
    VerilatedVcdC* tfp = new VerilatedVcdC;
    top->trace(tfp, 99);
    Verilated::traceEverOn(true);
    tfp->open(vcdfile);
    for(uint64_t i=0;i/2<WAVE_MAX_CYCLES&&!contextp->gotFinish();++i){
        contextp->timeInc(1);
        top->clock = i%2;
        top->reset = i<2;
        top->eval();
        tfp->dump(contextp->time());
    }
    tfp->close();
    delete top;
    delete contextp;
    return 0;
}