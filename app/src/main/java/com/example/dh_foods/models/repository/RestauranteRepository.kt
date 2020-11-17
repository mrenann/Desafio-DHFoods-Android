package com.example.dh_foods.models.repository

import com.example.dh_foods.models.Restaurante
import com.example.dh_foods.models.Restaurantes
import com.example.dh_foods.models.prato.PratoBusiness

class RestauranteRepository {

    fun getRestaurantes(): Restaurantes {

        val pratoBusiness: PratoBusiness = PratoBusiness()

        val restaurante1 = Restaurante("Tony Roma's","https://paginanews.com.br/wp-content/uploads/2020/08/feijoada.jpg","Av. Lavandisca, 717 - Indianópolis, São Paulo","22:00", pratoBusiness.getPratos().pratosList)
        val restaurante2 = Restaurante("Aoyama - Moema","https://img.cybercook.com.br/receitas/731/lasanha-3.jpeg","Alameda dos Arapanés, 532 - Moema","00:00")
        val restaurante3 = Restaurante("Outback - Moema","https://diaonline.ig.com.br/wp-content/uploads/2019/01/pizza-em-goiania-12-pizzarias-incriveis-para-conhecer.jpg","Av. Moaci, 187, 187 - Moema, São Paulo","00:00")
        val restaurante4 = Restaurante("Sí Señor!","https://img.buzzfeed.com/buzzfeed-static/static/2018-08/3/9/campaign_images/buzzfeed-prod-web-06/quantos-voce-gosta-de-comida-de-verdade-2-31093-1533301940-0_dblbig.jpg","Alameda Jauaperi, 626 - Moema","01:00")
        val restaurante5 = Restaurante("Saberes e Sabores","https://blog.emania.com.br/wp-content/uploads/2016/04/fotos-de-comida.jpg","Rua Doutor Floro Bartolomeu - Juazeiro do Norte","18:00")
        val restaurante6 = Restaurante("Mr Japão","https://bartzmoveis.com.br/wp-content/uploads/hashi-segurando-sushi-comida-japonesa.jpg","Rua Luis Soares - Campo Grande","22:00")
        val restaurante7 = Restaurante("Restaurante do Ogro","https://i0.statig.com.br/bancodeimagens/3a/8q/1u/3a8q1up0jcoye9viuabkbb8f4.jpg","Rua Projetada XXXIII - Três Irmãs, Campina Grande","22:00")
        val restaurante8 = Restaurante("PR Sobremesas","https://s2.glbimg.com/e7l50bVQQkmZeHI_ZocecKRMORg=/0x0:3000x2000/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_e84042ef78cb4708aeebdf1c68c6cbd6/internal_photos/bs/2019/s/B/6uXuhiSza5lGAKaaWuaA/sobremesa-na-taca-e-de-casa-receitas-gshow-3-.jpg","Rua São Paulo - Juazeiro do Norte","22:00")
        val restaurante9 = Restaurante("Regina Lanches e Delicias","https://img.olhardigital.com.br/uploads/acervo_imagens/2020/01/r16x9/20200108115647_1200_675_-_sobremesa.jpg","Rua das Juremas - Malvinas, Campina Grande ","22:00")
        val restaurante10 = Restaurante("A Torta","https://cdn.panelinha.com.br/receita/1322186400000-Massa-crocante-para-tortas.jpg","Rua Padre Cicero - Juazeiro do Norte, Ceará ","22:00")


        return Restaurantes(
                restaurantesList = mutableListOf(restaurante1,restaurante2,restaurante3,restaurante4
                        ,restaurante5,restaurante6,restaurante7,restaurante8,restaurante9,restaurante10)
        )
    }

}