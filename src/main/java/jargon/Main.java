package jargon;

import java.util.List;

/**
 * User: Mikhail Golubev
 * Date: 14.02.13
 * Time: 2:06
 */
public class Main {
    public static void main(String[] args) {
        OptionParser parser = OptionParser.newInstance("Test program").help(
                "Just sample program. Assume it's some kind of archive program"
        ).build();
        Option<Boolean> compressFlag = Options.newFlagOption("--compress", "-c").
                help("compress chosen file").build();
        parser.addOption(compressFlag);
        Option<Boolean> decompressFlag = Options.newFlagOption("--decompress", "-d").
                help("decompress chose file").build();
        parser.addOption(decompressFlag);
        Option<String> fileNameOption = Options.newStringOption("--file-name", "-f").
                help("target file").nargs(1).required(true).build();
        parser.addOption(fileNameOption);
        Option<Integer> compressionLevel = Options.newInteger("-l", "--level").
                help("Compression level").defaultValue(0).build();
        parser.addOption(compressionLevel);

        List<String> pos = parser.parse(args);
        System.out.println(pos);
        System.out.println("Compress: " + compressFlag.getValue());
        System.out.println("Decompress: " + decompressFlag.getValue());
        System.out.println("File name: " + fileNameOption.getValue());
        System.out.println("Compression level: " + compressionLevel.getValue());

    }
}
