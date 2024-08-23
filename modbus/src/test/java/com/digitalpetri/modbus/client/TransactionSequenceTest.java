package com.digitalpetri.modbus.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.digitalpetri.modbus.client.ModbusTcpClient.TransactionSequence;
import org.junit.jupiter.api.Test;

class TransactionSequenceTest {

  @Test
  void rollover() {
    TransactionSequence sequence = new TransactionSequence();

    // Assert that transactions are generated in the range [0, 65535]
    // and that they roll over back to 0.
    for (int i = 0; i < 2; i++) {
      for (int id = 0; id < 65536; id++) {
        assertEquals(id, sequence.next());
      }
    }
  }

}