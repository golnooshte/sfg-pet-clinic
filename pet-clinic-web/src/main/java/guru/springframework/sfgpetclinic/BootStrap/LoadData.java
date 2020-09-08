package guru.springframework.sfgpetclinic.BootStrap;

import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.model.vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class LoadData implements CommandLineRunner{
private  final OwnerService ownerService;
private  final VetService vetService;

    public LoadData() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
     owner owner1= new owner();
     owner1.setId(1L);
     owner1.setFirstName("Goli");
     owner1.setLastName("Teymouri");
     ownerService.save(owner1);


        owner owner2= new owner();
        owner1.setId(2L);
        owner1.setFirstName("mahdi");
        owner1.setLastName("Karaz");
        ownerService.save(owner2);

        vet vet1=new vet();
        vet1.setId(1L);
        vet1.setFirstName("goofi");
        vet1.setLastName("irooni");
        vetService.save(vet1);

        vet vet2=new vet();
        vet1.setId(2L);
        vet1.setFirstName("dori");
        vet1.setLastName("karazmoode");
        vetService.save(vet2);
        System.out.println("Loading vets");
    }
}