package guru.springframework.sfgpetclinic.BootStrap;

import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.model.vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class LoadData implements CommandLineRunner{
private  final OwnerService ownerService;
private  final VetService vetService;

    public LoadData(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;

    }
        @Override
    public void run(String... args) throws Exception {
     owner owner1= new owner();
     owner1.setId(1L);
     owner1.setFirstName("Goli");
     owner1.setLastName("Teymouri");
     ownerService.save(owner1);



        owner owner2= new owner();
        owner2.setId(2L);
        owner2.setFirstName("mahdi");
        owner2.setLastName("Karaz");
        ownerService.save(owner2);

        vet vet1=new vet();
        vet1.setId(1L);
        vet1.setFirstName("misha");
        vet1.setLastName("rohani");
        this.vetService.save(vet1);

        vet vet2=new vet();
        vet2.setId(2L);
        vet2.setFirstName("maryam");
        vet2.setLastName("asghari");
        this.vetService.save(vet2);
        System.out.println("Loading vets");
    }
}
