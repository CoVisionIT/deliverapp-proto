# DeliverApp-proto

This project contains the DeliverApp protobuf protocol file and its generated Java library. 

#### Get the library
For the Java library: add the deliverapp-proto repository and the deliverapp-proto dependency:

    <repositories>
        <repository>
            <id>deliverapp-proto</id>
            <url>https://raw.githubusercontent.com/CoVisionIT/deliverapp-proto/java6/artifacts</url>
        </repository>
    </repositories>

    <dependency>
        <groupId>be.covisionit</groupId>
        <artifactId>deliverapp-proto-java6</artifactId>
        <version>1.0.1</version>
    </dependency>

Alternatively, for C++, C#, GO or Python, copy the [protocol file](src/main/proto/be/covisionit/deliverapp/despatchadvice.proto) 
to your project and configure [Protocol buffers](https://developers.google.com/protocol-buffers/) to generate the library yourself.

#### Create the contents for a QR code

    import be.covisionit.deliverapp.proto.DespatchAdvice;
    import java.nio.charset.Charset;

    DespatchAdvice despatchAdvice = DespatchAdvice.newBuilder().setID("ID123").build();
    String qrString = new String(despatchAdvice.toByteArray(), Charset.forName("ISO-8859-1"));
    
    
#### Create a QR code image from the protobuf string

For example with the ZXing library:

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static Image toImage(String qrString, int size) throws WriterException {
        QRCodeWriter writer = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, ISO_8859_1.name());
        BitMatrix bitMatrix = writer.encode(qrString, BarcodeFormat.QR_CODE, size, size, hints);

        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_USHORT_565_RGB);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Color color = bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE;
                image.setRGB(x, y, color.getRGB());
            }
        }
        return image;
    }
