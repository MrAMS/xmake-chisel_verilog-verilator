module hello(
  input wire clock,
  input wire reset,
  output wire [2:0] io_out
);
  reg [2:0] cnt;
  always @(posedge clock) begin
    if(reset) begin
      cnt <= 0;
    end else begin
      cnt <= cnt + 1;
    end
  end
  assign io_out = cnt;
endmodule