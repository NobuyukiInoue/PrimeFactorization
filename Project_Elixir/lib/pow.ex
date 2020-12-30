defmodule Pow do
  require Integer

  def pow(_, 0), do: 1
  def pow(x, n) when Integer.is_odd(n), do: x * pow(x, n - 1)
  def pow(x, n) do
    result = pow(x, div(n, 2))
    result * result
  end

  def get2powbits(n) do
    get2powbits(n, 0)
  end

  def get2powbits(n, x) do
    if n >= Pow.pow(2, x) do
      get2powbits(n, x + 1)
    else
      x
    end
  end
end
