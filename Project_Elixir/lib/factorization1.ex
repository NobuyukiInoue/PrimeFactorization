defmodule Factorization1 do
  def execute(n) do
    str_n = Integer.to_string(n)
    str_n <> " < pow(2, " <> Integer.to_string(Pow.get2powbits(n)) <> ")" |> IO.puts
    exectime = Benchmark.measure(fn ->
      ls = factor(n)
      "n = " <> Integer.to_string(n) <> ", primes = " <> get_list(ls) |> IO.puts
      if list_mul(ls) == n do
        "Answer Check : OK" |> IO.puts
      else
        "Answer Check : NG" |> IO.puts
      end
    end)
    "Execute time : " <> Float.to_string(Float.round(exectime, 3)) <> " [s]" |> IO.puts
  end

  def get_list(ls) do
    "[" <> Enum.join(Enum.reverse(ls), ", ") <> "]"
  end

  def list_mul([l | ls]), do: l * list_mul(ls)
  def list_mul([]), do: 1

  def factor(n) do
    factor([], n, 2, trunc(:math.sqrt(n)))
  end

  def factor(p, n, x, limit) do
    cond do
      n == 1 -> p
      x > limit -> [n | p]
      rem(n, x) == 0 -> factor([x | p], div(n, x), x, limit)
      x == 2 -> factor(p, n, 3, limit)
      true -> factor(p, n, x + 2, limit)
    end
  end
end
