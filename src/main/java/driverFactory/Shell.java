package driverFactory;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Shell {
    public static ArrayList<String> command(final String cmdline,
                                            final String directory) {
        try {
            Process process =
                    new ProcessBuilder(new String[]{"bash", "-c", cmdline})
                            .redirectErrorStream(true)
                            .directory(new File(directory))
                            .start();
            ArrayList<String> output = new ArrayList<String>();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null)
                output.add(line);
            if (0 != process.waitFor())
                return null;
            return output;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] getDeviceDetails() throws IOException {
        command("adb start-server", ".");
        ArrayList<String> output = command("adb devices -l", ".");
        String [] deviceDetails = new String[2];
        if (null == output)
            throw new IOException("Device is not connected");
        else
            deviceDetails[0]= output.get(1).split("\t")[0];
            deviceDetails[1]= output.get(1).split("model:")[1].split(" ")[0];
            return deviceDetails;
    }
}

