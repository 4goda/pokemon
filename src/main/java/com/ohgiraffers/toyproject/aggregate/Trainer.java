package com.ohgiraffers.toyproject.aggregate;

import java.io.Serializable;
import java.util.Arrays;

public class Trainer implements Serializable {
        private int trainerNo;                                     // 트레이너 구분용 넘버
        private String trainerName;                                // 트레이너 이름(중복가능)

        private TrainerBag trainerBag;                             // 트레이너 가방

        private Pokemon[] trainerPokemons = new Pokemon[6];        // 트레이너가 보유한 포켓몬

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

        public Pokemon[] getTrainerPokemons() {
                return trainerPokemons;
        }

        public void setTrainerPokemons(Pokemon[] trainerPokemons) {
                this.trainerPokemons = trainerPokemons;
        }

        public void setTrainerPokemon(Pokemon pokemon) { trainerPokemons[0] = pokemon; }

        public Pokemon getTrainerFirstPokemon() {
                return trainerPokemons[0];
        }
        @Override
        public String toString() {
                return "Trainer{" +
                        "trainerNo=" + trainerNo +
                        ", trainerName='" + trainerName + '\'' +
                        ", trainerPokemons=" + Arrays.toString(trainerPokemons) +
                        '}';
        }

}
