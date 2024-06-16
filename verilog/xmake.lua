target("verilog_demo")
    add_rules("verilator.binary")
    set_toolchains("@verilator")
    add_files("vsrc/*.v")
    add_files("csrc/*.cpp")
    add_values("verilator.flags", "--trace", "--timing")

    add_options("WAVE_FILE_NAME", "WAVE_MAX_CYCLES", "CNTER_WIDTH")
    add_includedirs("$(buildir)")
    
    add_configfiles("csrc/config_verilog.h.in")
    after_run(function (target)
        os.exec("gtkwave %s/wave.vcd", target:targetdir())
    end)

    add_packages("fmt")