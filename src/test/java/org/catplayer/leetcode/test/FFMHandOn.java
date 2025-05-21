package org.catplayer.leetcode.test;

import org.junit.jupiter.api.Test;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.ValueLayout;

@SuppressWarnings("preview")
public class FFMHandOn {

    @Test
    public void test() {

        try (var arena = Arena.ofConfined()) {

            var string = arena.allocateUtf8String("catplayer");

            var linker = Linker.nativeLinker();

            var strlenMethodHandle = linker.downcallHandle(
                    linker.defaultLookup().find("strlen").orElseThrow(),
                    FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
            );

            try {
                var length = (long) strlenMethodHandle.invokeExact(string);

                System.out.printf("length: [%d]\n", length);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }

        }

    }
}
