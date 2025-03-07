package io.wulfcodes.rest.model.value;

public enum Gender {
    MALE('M'), FEMALE('F'), OTHER('O');

    private final Character notation;

    private Gender(Character notation) {
        this.notation = notation;
    }

    public Character getNotation() {
        return notation;
    }
}
