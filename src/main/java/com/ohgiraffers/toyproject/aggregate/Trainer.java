package com.ohgiraffers.toyproject.aggregate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trainer implements Serializable {
        private int trainerNo;                                     // 트레이너 구분용 넘버

        private String trainerName;                                // 트레이너 이름(중복가능)

        private TrainerBag trainerBag;                             // 트레이너 가방

//        private List<Integer> trainerPokemons = new ArrayList<>();        // 트레이너가 보유한 포켓몬(pr에 저장된 인덱스)
        private List<Pokemon> trainerPokemons = new ArrayList<>();        // 트레이너가 보유한 포켓몬(pr에 저장된 인덱스)

        public Trainer() {
                trainerBag = new TrainerBag();
        }

        public Trainer(int trainerNo, String trainerName) {
                this.trainerNo = trainerNo;
                this.trainerName = trainerName;
        }

        public int getTrainerNo() {
                return trainerNo;
        }

        public String getTrainerName() {
                return trainerName;
        }

        public TrainerBag getTrainerBag() {
                return trainerBag;
        }

//        public List<Integer> getTrainerPokemons() {
//                return trainerPokemons;
//        }
        public List<Pokemon> getTrainerPokemons() {
                return trainerPokemons;
        }

        public void setTrainerPokemons(List<Pokemon> trainerPokemons) {
                this.trainerPokemons = trainerPokemons;
        }

        public void setTrainerPokemon(Pokemon pokemon) { trainerPokemons.add(pokemon); }


        public String getTrainerPokemon(int idx) { return trainerPokemons.get(idx).getName(); }

//        public static int getTrainerFirstPokemon() {
//                return trainerPokemons.get(0);
//        }

        @Override
        public String toString() {
                return "Trainer{" +
                        "trainerNo=" + trainerNo +
                        ", trainerName='" + trainerName + '\'' +
                        ", trainerBag=" + trainerBag +
                        ", trainerPokemons=" + trainerPokemons +
                        '}';
        }
}
