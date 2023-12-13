package com.conquestreforged.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStream {

    public static class Input extends ByteArrayInputStream {

        public Input(byte[] buf, int length) {
            super(buf, 0, length);
        }

        public OutputStream toOutputStream() {
            return new Output();
        }
    }

    public static class Output extends ByteArrayOutputStream {

        public InputStream toInputStream() throws IOException {
            flush();
            return new Input(super.buf, super.count);
        }
    }
}
