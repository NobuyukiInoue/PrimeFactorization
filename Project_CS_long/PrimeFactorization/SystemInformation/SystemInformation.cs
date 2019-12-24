using System;

namespace Project_CS
{
    public class SystemInformation
    {
        public void PrintSystemInformation()
        {
             System.OperatingSystem os = System.Environment.OSVersion;
             Console.WriteLine("=====================================================================================");
             Console.WriteLine("{0,-10}: {1}", "Date", DateTime.Now);
             Console.WriteLine("{0,-10}: {1}", "OS", os.ToString());
             Console.WriteLine("{0,-10}: {1}", "Language", "C#");
             Console.WriteLine("=====================================================================================");
        }
    }
}
