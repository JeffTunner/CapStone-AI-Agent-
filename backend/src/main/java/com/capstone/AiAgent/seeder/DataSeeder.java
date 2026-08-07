package com.capstone.AiAgent.seeder;

import com.capstone.AiAgent.model.Product;
import com.capstone.AiAgent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() > 0) return;

        Product p = new Product();
        p.setName("boAt Airdopes 141");
        p.setCategory("Audio");
        p.setBrand("boAt");
        p.setPrice(new BigDecimal("1299"));
        p.setRating(4.2);
        p.setStock(58);
        p.setDescription("Wireless earbuds with 42-hour playback and low latency");
        p.setTags(List.of("wireless", "bluetooth", "earbuds", "sports"));
        productRepository.save(p);

        Product p1 = new Product();
        p1.setName("Noise Buds VS104");
        p1.setCategory("Audio");
        p1.setBrand("Noise");
        p1.setPrice(new BigDecimal("1099"));
        p1.setRating(4.0);
        p1.setStock(34);
        p1.setDescription("TWS earbuds with quad-mic ENC and fast charging");
        p1.setTags(List.of("wireless", "bluetooth", "earbuds"));
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setName("Nike Revolution 7");
        p2.setCategory("Footwear");
        p2.setBrand("Nike");
        p2.setPrice(new BigDecimal("3495"));
        p2.setRating(4.5);
        p2.setStock(12);
        p2.setDescription("Lightweight running shoes with soft foam cushioning");
        p2.setTags(List.of("running", "sports", "shoes"));
        productRepository.save(p2);

        Product p3 = new Product();
        p3.setName("Puma Softride");
        p3.setCategory("Footwear");
        p3.setBrand("Puma");
        p3.setPrice(new BigDecimal("2999"));
        p3.setRating(4.3);
        p3.setStock(0);
        p3.setDescription("Everyday running shoes with breathable mesh upper");
        p3.setTags(List.of("running", "sports", "shoes"));
        productRepository.save(p3);

        Product p4 = new Product();
        p4.setName("Noise ColorFit Pulse 2");
        p4.setCategory("Wearables");
        p4.setBrand("Noise");
        p4.setPrice(new BigDecimal("1499"));
        p4.setRating(4.1);
        p4.setStock(41);
        p4.setDescription("Smartwatch with 1.8 inch display and SpO2 tracking");
        p4.setTags(List.of("smartwatch", "fitness", "wearable"));
        productRepository.save(p4);

        Product p5 = new Product();
        p5.setName("boAt Rockerz 255 Pro");
        p5.setCategory("Audio");
        p5.setBrand("boAt");
        p5.setPrice(new BigDecimal("1499"));
        p5.setRating(4.4);
        p5.setStock(27);
        p5.setDescription("Neckband with 40-hour playback and ASAP charge");
        p5.setTags(List.of("wireless", "bluetooth", "neckband", "sports"));
        productRepository.save(p5);
    }
}
