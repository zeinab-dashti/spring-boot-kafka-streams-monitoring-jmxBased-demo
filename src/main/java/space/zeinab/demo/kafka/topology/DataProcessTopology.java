package space.zeinab.demo.kafka.topology;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import space.zeinab.demo.kafka.config.KafkaConfig;

@Component
public class DataProcessTopology {

    @Autowired
    public void buildPipeline(StreamsBuilder streamsBuilder) {

        KStream<String, String> inputStream = streamsBuilder.stream(KafkaConfig.INPUT_TOPIC, Consumed.with(Serdes.String(), Serdes.String()));
        inputStream.print(Printed.<String, String>toSysOut().withLabel("Input Stream"));

        inputStream.mapValues(value -> "Processed: " + value)
                .to(KafkaConfig.OUTPUT_TOPIC, Produced.with(Serdes.String(), Serdes.String()));
    }
}
