defmodule Primefactorization do
  @moduledoc """
  Documentation for Primefactorization.
  """

  @doc """
  """
  def main(args \\ []) do
    if Enum.count(args) < 1 do
      exit("Usage) primefactorization <n>")
    end
  # IO.puts("args = " <> Enum.join(args, ", "))
    {n, ""} = Integer.parse(hd args)

    datetime = NaiveDateTime.utc_now
    "=====================================================================================" |> IO.puts
    "Date      : " |> IO.write
    datetime |> IO.puts
    "Language  : Elixir" |> IO.puts
    "=====================================================================================" |> IO.puts
  # Factorization1.execute(n)
  # IO.puts ""
    Factorization2.execute(n)
  end
end
