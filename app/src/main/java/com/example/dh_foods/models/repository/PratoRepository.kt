package com.example.dh_foods.models.repository

import com.example.dh_foods.models.Prato
import com.example.dh_foods.models.Pratos

class PratoRepository {

    fun getPratos(): Pratos {

        val prato1 = Prato("Sushi Japones","https://bartzmoveis.com.br/wp-content/uploads/hashi-segurando-sushi-comida-japonesa.jpg","Rato roeu a roupa do rei de Roma")
        val prato2 = Prato("Coxinhas","https://revistabula.com/wp/wp-content/uploads/2019/06/coxinha.jpg","Rato roeu a roupa do rei de Roma")
        val prato3 = Prato("Tapioca Gourmet de Algum Lugar","https://i2.wp.com/brasil.cambly.com/wp-content/uploads/2019/03/shutterstock_1151228951.jpg?resize=800%2C534&ssl=1","Rato roeu a roupa do rei de Roma")
        val prato4 = Prato("Hamburguer","https://gazetaweb.globo.com/fotosPortal/portal_gazetaweb_com/diversao__variedades/foto_grande/2019/03/201903291558_e4de030fd8.jpeg","Rato roeu a roupa do rei de Roma")
        val prato5 = Prato("Pizza","https://aguiaoperadora.com.br/wp-content/uploads/2018/04/destaque-1-1024x576.png","Rato roeu a roupa do rei de Roma")
        val prato6 = Prato("Batatas Fritas","https://img.itdg.com.br/tdg/images/recipes/000/130/091/127965/127965_original.jpg?mode=crop&width=710&height=400","Rato roeu a roupa do rei de Roma")
        val prato7 = Prato("Milk Shake","https://www.dicasdemulher.com.br/wp-content/uploads/2019/03/milk-shake.jpg","Rato roeu a roupa do rei de Roma")
        val prato8 = Prato("Lasanha","https://www.receitasagora.com.br/wp-content/uploads/2020/02/receita-de-lasanha-com-escondidinho-de-carne-moida.jpg","Rato roeu a roupa do rei de Roma")
        val prato9 = Prato("Feijoada","https://www.brasilcomsabor.com/wp-content/uploads/2020/06/Webp.net-compress-image-6.jpg","Rato roeu a roupa do rei de Roma")
        val prato10 = Prato("Macarronada","https://receitasdahora.com/wp-content/uploads/2019/10/a-melhor-macarronada-de-calabres.jpg","Rato roeu a roupa do rei de Roma")


        return Pratos(
                pratosList = mutableListOf(prato1,prato2,prato3,prato4,prato5,prato6,prato7,prato8,prato9,prato10)
        )
    }

}