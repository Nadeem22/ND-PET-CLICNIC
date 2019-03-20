package nadeem.springframework.ndpetclinic.bootstrap;

import nadeem.springframework.ndpetclinic.model.Owner;
import nadeem.springframework.ndpetclinic.model.Vet;
import nadeem.springframework.ndpetclinic.services.OwnerService;
import nadeem.springframework.ndpetclinic.services.VetService;
import nadeem.springframework.ndpetclinic.services.map.OwnerServiceMap;
import nadeem.springframework.ndpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;

    public DataLoader() {
        ownerService=new OwnerServiceMap();
        vetService=new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Nadeem");
        owner1.setLastName("siddiqui");
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mohammad");
        owner2.setLastName("sharique");
        ownerService.save(owner2);

        System.out.println("Owner Loaded");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("pradeep");
        vet1.setLastName("Soma");
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet1.setFirstName("Avinash");
        vet1.setLastName("Kumar");
        vetService.save(vet2);

        System.out.println("Vet is Loaded");

    }
}
